package com.ml.tree2.model.impl;

import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

public class MLTreeSelectionModel extends DefaultTreeSelectionModel {
private static final long serialVersionUID = -4270031800448415780L;

@Override
public void addSelectionPath(TreePath path) {
    // Don't do overriding logic here because addSelectionPaths is ultimately called.
    super.addSelectionPath(path);
}

@Override
public void addSelectionPaths(TreePath[] paths) {
    if(paths != null) {
        for(TreePath path : paths) {

            TreePath[] toAdd = new TreePath[1];
            toAdd[0] = path;

            if (isPathSelected(path)) {
                // If path has been previously selected REMOVE THE SELECTION.
                super.removeSelectionPaths(toAdd);
            } else {
                // Else we really want to add the selection...
                super.addSelectionPaths(toAdd);
            }
        }
    }
}