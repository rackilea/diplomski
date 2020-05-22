package com.mxgraph.examples.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;

/**
 * A foldable directed acyclic graph (DAG) where each child has only one parent. AKA a Tree.
 * 
 * @author some programmer
 *
 */
class FoldableTree extends mxGraph
{
    /**
     * Need to add some conditions that will get us the expand/collapse icon on the vertex.
     */
    @Override
    public boolean isCellFoldable(Object cell, boolean collapse)
    {
        //I want to keep the original behavior for groups in case I use a group someday.
        boolean result = super.isCellFoldable(cell, collapse);
        if(!result)
        {
            //I also want cells with outgoing edges to be foldable...
            return this.getOutgoingEdges(cell).length > 0;
        }
        return result;
    }

    /**
     * Need to define how to fold cells for our DAG. In this case we want to traverse the tree collecting
     * all child vertices and then hide/show them and their edges as needed. 
     */
    @Override
    public Object[] foldCells(boolean collapse, boolean recurse, Object[] cells, boolean checkFoldable)
    {
        //super.foldCells does this so I will too...
        if(cells == null)
        {
            cells = getFoldableCells(getSelectionCells(), collapse);
        }

        this.getModel().beginUpdate();

        try
        {           
            toggleSubtree(this, cells[0], !collapse);
            this.model.setCollapsed(cells[0], collapse);
            fireEvent(new mxEventObject(mxEvent.FOLD_CELLS, "cells", cells, "collapse", collapse, "recurse", recurse));
        }
        finally
        {
            this.getModel().endUpdate();
        }

        return cells;
    }

    // Updates the visible state of a given subtree taking into
    // account the collapsed state of the traversed branches
    private void toggleSubtree(mxGraph graph, Object cellSelected, boolean show)
    {
        List<Object> cellsAffected = new ArrayList<>();
        graph.traverse(cellSelected, true, new mxICellVisitor() {                   
                    @Override
                    public boolean visit(Object vertex, Object edge) {
                        // We do not want to hide/show the vertex that was clicked by the user to do not
                        // add it to the list of cells affected.
                        if(vertex != cellSelected)
                        {
                            cellsAffected.add(vertex);
                        }

                        // Do not stop recursing when vertex is the cell the user clicked. Need to keep
                        // going because this may be an expand.
                        // Do stop recursing when the vertex is already collapsed.
                        return vertex == cellSelected || !graph.isCellCollapsed(vertex); 
                    }
                });

        graph.toggleCells(show, cellsAffected.toArray(), true/*includeEdges*/);     
    }
}

public class ChampsTree extends JFrame
{
    private static final long serialVersionUID = -2707712944901661771L;

    public ChampsTree()
    {
        super("Hello, World!");

        FoldableTree graph = new FoldableTree();

        mxCompactTreeLayout layout = new mxCompactTreeLayout(graph, false);         
        layout.setUseBoundingBox(false);
        layout.setEdgeRouting(false);
        layout.setLevelDistance(30);
        layout.setNodeDistance(10);

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {           
            Object root = graph.insertVertex(parent, "treeRoot", "Root", 0, 0, 60, 40);

            Object v1 = graph.insertVertex(parent, "v1", "Child 1", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v1);

            Object v2 = graph.insertVertex(parent, "v2", "Child 2", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v2);

            Object v3 = graph.insertVertex(parent, "v3", "Child 3", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v3);

            Object v11 = graph.insertVertex(parent, "v11", "Child 1.1", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v1, v11);

            Object v12 = graph.insertVertex(parent, "v12", "Child 1.2", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v1, v12);

            Object v21 = graph.insertVertex(parent, "v21", "Child 2.1", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v2, v21);

            Object v22 = graph.insertVertex(parent, "v22", "Child 2.2", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v2, v22);

            Object v221 = graph.insertVertex(parent, "v221", "Child 2.2.1", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v22, v221);

            Object v222 = graph.insertVertex(parent, "v222", "Child 2.2.2", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v22, v222);

            Object v31 = graph.insertVertex(parent, "v31", "Child 3.1", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v3, v31);            

            layout.execute(parent);         
        }
        finally
        {
            graph.getModel().endUpdate();
        }

        graph.addListener(mxEvent.FOLD_CELLS,  new mxIEventListener() {

            @Override
            public void invoke(Object sender, mxEventObject evt) {
                layout.execute(graph.getDefaultParent());
            }
        });

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);
    }

    public static void main(String[] args)
    {
        ChampsTree frame = new ChampsTree();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}