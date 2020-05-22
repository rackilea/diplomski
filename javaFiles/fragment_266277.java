Writer w = null;
    MavenXpp3Writer mavenXpp3Writer = new MavenXpp3Writer();

    try {
        List<JarDetails> uniquejarDetails = removeDuplicateJars (jarDetails);

        w = WriterFactory.newWriter (new File(location + "pom.xml"), "UTF-8");

        Model model = new Model();
        model.setGroupId("com.projectname");
        model.setArtifactId("project-analyzer");
        model.setVersion("1.0");
        model.setModelVersion("4.0.0");

        List<Dependency> dependencies = new ArrayList<Dependency>();            

        Plugin copyDependency = new Plugin();
        copyDependency.setGroupId("org.apache.maven.plugins");
        copyDependency.setArtifactId("maven-dependency-plugin");
        copyDependency.setVersion("2.10");

        PluginExecution copyDependencyPluginExecution = new PluginExecution();
        copyDependencyPluginExecution.setId("copy-dependencies");
        copyDependencyPluginExecution.setPhase("generate-sources");

        List<String> copyDependencyGoalsList = new ArrayList<String>();
        copyDependencyGoalsList.add("copy-dependencies");
        copyDependencyPluginExecution.setGoals(copyDependencyGoalsList);


        Plugin plugin = new Plugin();
        plugin.setGroupId("com.coderplus.maven.plugins");
        plugin.setArtifactId("copy-rename-maven-plugin");
        plugin.setVersion("1.0.1");

        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.setId("copy-jars");
        pluginExecution.setPhase("generate-sources");

        List<String> goalsList = new ArrayList<String>();
        goalsList.add("copy");
        pluginExecution.setGoals(goalsList);

        String domString = "<configuration><fileSets>";

        for (int jarCount = 0; jarCount < uniquejarDetails.size(); jarCount++) {
            if (uniquejarDetails.get(jarCount).getDependencyMetadata().getGroupId() != null) {

            Dependency dependency = new Dependency();

            dependency.setGroupId(uniquejarDetails.get(jarCount).getDependencyMetadata().getGroupId());
            dependency.setArtifactId(uniquejarDetails.get(jarCount).getDependencyMetadata().getArtifactId());
            dependency.setVersion(uniquejarDetails.get(jarCount).getDependencyMetadata().getVersion());
            dependencies.add(dependency);

            //Add copy-rename-maven-plugin configurations
            String mavenJarName = uniquejarDetails.get(jarCount).getDependencyMetadata().getArtifactId() + "-"
                    + uniquejarDetails.get(jarCount).getDependencyMetadata().getVersion() + ".jar";
            String mavenJar = "target/dependency/" + mavenJarName;

            domString += "<fileSet><sourceFile>" + mavenJar + "</sourceFile>";
            domString += "<destinationFile>" + new File(uniquejarDetails.get(jarCount).getJarRelativePath() + 
                    "/" + mavenJarName) + "</destinationFile></fileSet>";
            }
        }

        domString += "</fileSets></configuration>";

        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(domString));
        Xpp3Dom dom = Xpp3DomBuilder.build(new StringReader(domString));

        pluginExecution.setConfiguration(dom);

        List<PluginExecution> pluginExecuionList = new ArrayList<PluginExecution>();
        pluginExecuionList.add(pluginExecution);

        List<PluginExecution> copyDependencyPluginExecuionList = new ArrayList<PluginExecution>();
        copyDependencyPluginExecuionList.add(copyDependencyPluginExecution);

        plugin.setExecutions (pluginExecuionList);
        copyDependency.setExecutions (copyDependencyPluginExecuionList);

        List<Plugin> pluginList = new ArrayList<Plugin> ();
        pluginList.add(copyDependency);
        pluginList.add(plugin);

        Build build = new Build();
        build.setPlugins(pluginList);

        model.setDependencies(dependencies);
        model.setBuild(build);

        mavenXpp3Writer.write(w, model);

    } catch (UnsupportedEncodingException e) {
        LOGGER.error(e.getMessage(), e);

    } catch (FileNotFoundException e) {
        LOGGER.error(e.getMessage(), e);

    } catch (IOException e) {
        LOGGER.error(e.getMessage(), e);

    } catch (FactoryConfigurationError e) {
        e.printStackTrace();

    } catch (XmlPullParserException e) {
        e.printStackTrace();

    } finally {
        try {
            if (w != null)
                w.close();
        } catch (IOException e) {
            LOGGER.error (e.getMessage(), e);
        }
    }