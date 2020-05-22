String url;

          String script = "<script type='text/javascript'>" 
                        + " window.parent.CKEDITOR.tools.callFunction(1, '" + url + "', '');" + "</script>";

          PrintWriter out = null;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          out.println(script);