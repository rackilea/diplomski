double resizeBorderThickness = 6;
double cornerSize = 24;

Region n = new Region();
n.setCursor(Cursor.N_RESIZE);
n.setMinHeight(resizeBorderThickness);
Region s = new Region();
s.setCursor(Cursor.S_RESIZE);
s.setMinHeight(resizeBorderThickness);
Region e = new Region();
e.setCursor(Cursor.E_RESIZE);
e.setMinWidth(resizeBorderThickness);
Region w = new Region();
w.setCursor(Cursor.W_RESIZE);
w.setMinWidth(resizeBorderThickness);

Region nw = new Region();
nw.setCursor(Cursor.NW_RESIZE);
nw.setMinSize(cornerSize, cornerSize);
Region ne = new Region();
ne.setCursor(Cursor.NE_RESIZE);
ne.setMinSize(cornerSize, cornerSize);
Region sw = new Region();
sw.setCursor(Cursor.SW_RESIZE);
sw.setMinSize(cornerSize, cornerSize);
Region se = new Region();
se.setCursor(Cursor.SE_RESIZE);
se.setMinSize(cornerSize, cornerSize);

GridPane resizePane = new GridPane();
resizePane.addRow(0, nw, n, ne);
resizePane.addRow(2, sw, s, se);
resizePane.add(w, 0, 1);
resizePane.add(e, 2, 1);

GridPane.setHgrow(n, Priority.ALWAYS);
GridPane.setHgrow(s, Priority.ALWAYS);
GridPane.setVgrow(w, Priority.ALWAYS);
GridPane.setVgrow(e, Priority.ALWAYS);

StackPane stackPane = new StackPane(resizePane, webView);
StackPane.setMargin(webView, new Insets(resizeBorderThickness));

Scene scene = new Scene(stackPane);