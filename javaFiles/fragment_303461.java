Field jrViewerField;
            try {
                jrViewerField = viewer.getClass().getDeclaredField("viewer");

                jrViewerField.setAccessible(true);
                JRViewer jrViewer = (JRViewer) jrViewerField.get(viewer);
                List<JRSaveContributor> savers = new ArrayList<JRSaveContributor>();
                for (JRSaveContributor sc : jrViewer.getSaveContributors()) {

                        savers.add(sc);

                }

                for (JRSaveContributor sc : savers) {
                    if (! sc.getClass().getName().toLowerCase().contains("pdf")) {
                        jrViewer.removeSaveContributor(sc);
                    }
                }


            } catch (Exception ex) {
              ex.printStackTrace();
            }