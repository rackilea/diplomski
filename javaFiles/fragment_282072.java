conf.getTooltip().setPointFormatter(
            "function() { " +
              "var category = this.x; " +
              "var multiplier = 10; " +
              "switch (category) " + 
              "{ " + 
              "   case 0: " + 
              "       multiplier = 10; " + 
              "       break; " + 
              "   case 1: " + 
              "       multiplier = 20; " + 
              "       break; " + 
              "   case 2: " + 
              "       multiplier = 30; " + 
              "       break; " + 

              "   default:  " + 
              "       multiplier = 50; " + 
              "}" +
              "var tipTxt = this.series.name + ': <b>' + this.y*multiplier + '</b><br>'; " +
              "return tipTxt; " +
              "}"  
            );