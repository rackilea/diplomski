for (MethodInvocation method : visitor.getMethods()) {
                if (method.resolveMethodBinding().isDeprecated()) {
                    for (IAnnotationBinding iab: method.resolveMethodBinding()
                            .getAnnotations()) {
                        for (IMemberValuePairBinding ivab: iab.getAllMemberValuePairs()) {
                            System.out.println(ivab.getKey());
                            System.out.println(ivab.getValue());
                        }
                    }
                    String deprecatedMethod = method.getName().toString();
                    String fileName = parse.getJavaElement().getResource()
                            .getName();
                    String packageName = method.resolveMethodBinding()
                            .getDeclaringClass().getQualifiedName();
                    String library = findLibrary(packageName);
                    if (treeMap.get(library).isEmpty()
                            || treeMap.get(library).get(deprecatedMethod)
                                    .isEmpty()) {
                        Map<String, Set<String>> innerMap = new HashMap<String, Set<String>>();
                        Set<String> fileNames = new HashSet<String>();
                        fileNames.add(fileName);
                        innerMap.put(deprecatedMethod, fileNames);
                        treeMap.put(library, innerMap);
                    } else {
                        Map<String, Set<String>> innerMap = treeMap
                                .get(library);
                        innerMap.get(deprecatedMethod).add(fileName);
                    }

                }
            }