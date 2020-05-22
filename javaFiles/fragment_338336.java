package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class MyGdxGame extends ApplicationAdapter {
    private Stage stage;

    private ScrollPane scrollPane1;
    private Stack stack;
    private Table stickyHeader;
    private Container<Table> tableContainer;
    private Cell<Container<Table>> oldCell;

    @Override
    public void create() {
        stage = new Stage();

        Table baseContainer = new Table();

        Table container = new Table();
        scrollPane1 = new ScrollPane(container) {
            @Override
            protected void scrollY(float pixelsY) {
                super.scrollY(pixelsY);

                if (pixelsY >= 100F) {
                    stack.add(tableContainer);
                } else {
                    oldCell.setActor(tableContainer);
                }
            }
        };

        Table list = new Table();

        Table mainHeader = new Table();
        mainHeader.background(new TextureRegionDrawable(this.getPixel()).tint(Color.GRAY));

        stickyHeader = new Table();
        tableContainer = new Container<Table>(stickyHeader);
        container.add(mainHeader).height(100).growX();
        container.row();
        oldCell = container.add(tableContainer.fill().top().height(100)).height(100).growX();
        container.row();
        container.add(list).grow();

        baseContainer.setFillParent(true);
        stack = new Stack();
        stack.setFillParent(true);
        stack.add(scrollPane1);

        stage.addActor(stack);

        Gdx.input.setInputProcessor(stage);

        this.fillDummyDataInHeader(stickyHeader);
        this.fillDummyDataInList(list);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void fillDummyDataInHeader(Table stickyHeader) {
        stickyHeader.background(new TextureRegionDrawable(this.getPixel()).tint(new Color(0.1960F, 0.3921F, 0.7843F, 0.8F)));
        Image ic = new Image(new Texture("badlogic.jpg"));
        Label label = new Label("Hi, I am sticky header!", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        label.setAlignment(Align.left);
        stickyHeader.add(ic).pad(10).left().size(50);
        stickyHeader.add(label).pad(10).left().growX();
    }

    private void fillDummyDataInList(Table list) {
        for (int i = 0; i < 10; i++) {
            Table row = new Table().background(new TextureRegionDrawable(this.getPixel()).tint(new Color(1F, 0.63921F, 0, 0.6F)));
            Image ic = new Image(new Texture("badlogic.jpg"));
            Label label = new Label("Row Item [" + (i + 1) + "]", new Label.LabelStyle(new BitmapFont(), Color.DARK_GRAY));
            row.add(ic).pad(20).size(40);
            row.add(label).height(100).growX();

            list.add(row).pad(20).padTop(0).growX();
            list.row();
        }
    }

    private Texture getPixel() {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(1F, 1F, 1F, 1F);
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

}