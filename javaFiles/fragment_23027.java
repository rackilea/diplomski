<s:select cssStyle  = "float: none; margin: 0 0 0 30px;"
          name      = "partie"
          id        = "select_partie"
          value     = "gallery.partie.id"
          list      = "equipesParties[%{#cpt.index}]"
          listKey   = "id"
          listValue = "gameName" 
/>