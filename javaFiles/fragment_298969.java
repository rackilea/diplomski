interface Renderer {
      void renderTemplate();
 }

 static final Render[] renderers = new Render[] {
    new Renderer {
         public void renderTemplate() {
             // Create config object for the rendering of 1
             // and calls render();
          }
    },
    new Renderer {
         public void renderTemplate() {
             // Create config object for the rendering of 2
             // and calls render();
          }
    },

 }

 public static void generate() {
    for (Renderer r: renderers) {
        r.renderTemplate();
    }
 }