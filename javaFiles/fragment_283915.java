/* =================
 * FXGraphics2DDemo3
 * =================
 * 
 * Copyright (c) 2014, Object Refinery Limited.
 * All rights reserved.
 *
 * http://www.jfree.org/fxgraphics2d/index.html
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   - Neither the name of the Object Refinery Limited nor the
 *     names of its contributors may be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL OBJECT REFINERY LIMITED BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */

package org.jfree.fx.demo;

import static javafx.application.Application.launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jfree.fx.FXGraphics2D;

import org.scilab.forge.jlatexmath.Box;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

/**
 * http://stackoverflow.com/questions/25027060/running-swing-application-in-javafx
 */
public class FXGraphics2DDemo3 extends Application {

    static class MyCanvas extends Canvas { 

        private FXGraphics2D g2;

        private Box box;

        public MyCanvas() {
            this.g2 = new FXGraphics2D(getGraphicsContext2D());
            this.g2.scale(20, 20);

            // create a formula
            TeXFormula formula = new TeXFormula("x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}");
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);

            // the 'Box' seems to be the thing we can draw directly to Graphics2D
            this.box = icon.getBox();

            // Redraw canvas when size changes. 
            widthProperty().addListener(evt -> draw()); 
            heightProperty().addListener(evt -> draw()); 
        }  

        private void draw() { 
            double width = getWidth(); 
            double height = getHeight();
            getGraphicsContext2D().clearRect(0, 0, width, height);
            this.box.draw(g2, 1, 5);
        } 

        @Override 
        public boolean isResizable() { 
            return true;
        }  

        @Override 
        public double prefWidth(double height) { return getWidth(); }  

        @Override 
        public double prefHeight(double width) { return getHeight(); } 
    } 


    @Override 
    public void start(Stage stage) throws Exception {
        javafx.scene.text.Font.loadFont(FXGraphics2DDemo3.class.getResourceAsStream("/org/scilab/forge/jlatexmath/fonts/base/jlm_cmmi10.ttf"), 1);
        javafx.scene.text.Font.loadFont(FXGraphics2DDemo3.class.getResourceAsStream("/org/scilab/forge/jlatexmath/fonts/maths/jlm_cmsy10.ttf"), 1);
        javafx.scene.text.Font.loadFont(FXGraphics2DDemo3.class.getResourceAsStream("/org/scilab/forge/jlatexmath/fonts/latin/jlm_cmr10.ttf"), 1);
        MyCanvas canvas = new MyCanvas();
        StackPane stackPane = new StackPane(); 
        stackPane.getChildren().add(canvas);  
        // Bind canvas size to stack pane size. 
        canvas.widthProperty().bind( stackPane.widthProperty()); 
        canvas.heightProperty().bind( stackPane.heightProperty());  
        stage.setScene(new Scene(stackPane)); 
        stage.setTitle("FXGraphics2DDemo3.java"); 
        stage.setWidth(700);
        stage.setHeight(390);
        stage.show(); 

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}