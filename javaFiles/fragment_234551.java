at= AffineTransform.getTranslateInstance( -1* drawing_cx,  -1*drawing_cy);
//gr.translate(-1 * drawing_cx, -1 * drawing_cy);
//gr.TranslateTransform(0, 0)
double scale_x=gr_width / drawing_rect.getWidth();
double scale_y=gr_height / Math.abs(drawing_rect.getHeight());

scale_x = Math.min(scale_x, scale_y);
scale_y = scale_x;
scale_x = Math.abs(scale_x);
// at = AffineTransform.getScaleInstance(scale_x, -1 * scale_y);

gr.scale(Math.round(scale_x), Math.round( scale_y));
//gr.scale(1.2, 1.2);
//gr.transform(tt);
gr.transform(at);

//' Translate to center over the drawing area.
 graphics_cx =gr_width / 2;
 graphics_cy = gr_height / 2;
gr.translate(graphics_cx, graphics_cy);