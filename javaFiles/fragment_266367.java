package com.fxgraph.cells;

import javafx.scene.control.Button;

import com.fxgraph.graph.Cell;

public class ButtonCell extends Cell {

    public ButtonCell(String id) {
        super(id);

        Button view = new Button(id);

        setView(view);

    }

}

package com.fxgraph.cells;

import javafx.scene.image.ImageView;

import com.fxgraph.graph.Cell;

public class ImageCell extends Cell {

    public ImageCell(String id) {
        super(id);

        ImageView view = new ImageView("http://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Siberischer_tiger_de_edit02.jpg/800px-Siberischer_tiger_de_edit02.jpg");
        view.setFitWidth(100);
        view.setFitHeight(80);

        setView(view);

    }

}


package com.fxgraph.cells;

import javafx.scene.control.Label;

import com.fxgraph.graph.Cell;

public class LabelCell extends Cell {

    public LabelCell(String id) {
        super(id);

        Label view = new Label(id);

        setView(view);

    }

}

package com.fxgraph.cells;

import javafx.scene.control.TitledPane;

import com.fxgraph.graph.Cell;

public class TitledPaneCell extends Cell {

    public TitledPaneCell(String id) {
        super(id);

        TitledPane view = new TitledPane();
        view.setPrefSize(100, 80);

        setView(view);

    }

}