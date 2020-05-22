if (directory) {

                File oldFile = fmng.currentFile;
                File newFile = new File(oldFile.getParent(), renameTo);
                Files.move(oldFile.toPath(), newFile.toPath());

                //System.out.println("path" + newFile.getPath());

                TreePath currentPath = fmng.findTreePath(fmng.currentFile);
                //System.out.println(currentPath);
                DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath.getLastPathComponent();

                fmng.treeModel.removeNodeFromParent(currentNode);

                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                fmng.treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());

                //fmng.setFileDetails(newFile);
                renamed = true;
            } else {
                renamed = fmng.currentFile.renameTo(new File(fmng.currentFile.getParentFile(), renameTo));
            }
            if (renamed) {
                fmng.showChildren(parentNode);
            } else {
                String msg = "The file '" + fmng.currentFile + "' could not be renamed.";
                fmng.showErrorMessage(msg, "Rename Failed");
            }