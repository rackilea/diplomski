private static String[] tokenizePath(String path) {
        List<String> l = new ArrayList<String>();
        StringTokenizer tok = new StringTokenizer(path, ":;", true); // NOI18N


    .....
        }

static File findPlatform() {
        String clusterPath = System.getProperty("cluster.path.final"); // NOI18N
        if (clusterPath != null) {
            for (String piece : tokenizePath(clusterPath)) {
                File d = new File(piece);
                if (d.getName().matches("platform\\d*")) {
                    return d;
                }
            }
        }
        String allClusters = System.getProperty("all.clusters"); // #194794
        if (allClusters != null) {
            File d = new File(allClusters, "platform"); // do not bother with old numbered variants
            if (d.isDirectory()) {
                return d;
            }
        }


    ....
        }

static void findClusters(Collection<File> clusters, List<String> regExps) throws IOException {
        File plat = findPlatform().getCanonicalFile();
        String selectiveClusters = System.getProperty("cluster.path.final"); // NOI18N
        Set<File> path;
        if (selectiveClusters != null) {
            path = new TreeSet<File>();
            for (String p : tokenizePath(selectiveClusters)) {
                File f = new File(p);
                path.add(f.getCanonicalFile());
            }
        } else {
            File parent;
            String allClusters = System.getProperty("all.clusters"); // #194794
            if (allClusters != null) {
                parent = new File(allClusters);
            } else {
                parent = plat.getParentFile();
            }
            path = new TreeSet<File>(Arrays.asList(parent.listFiles()));
        }


....
        }