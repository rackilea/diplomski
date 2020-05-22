protected void initComponentDefaults(UIDefaults table) {
  super.initComponentDefaults(table);

  Object fim = table.get("TextField.focusInputMap");

  Object fieldInputMap = new UIDefaults.LazyInputMap(new Object[] {
                     "ctrl C", DefaultEditorKit.copyAction,
                     "ctrl V", DefaultEditorKit.pasteAction,
                     "ctrl X", DefaultEditorKit.cutAction,
                       "COPY", DefaultEditorKit.copyAction,
                      "PASTE", DefaultEditorKit.pasteAction,
                        "CUT", DefaultEditorKit.cutAction,
             "control INSERT", DefaultEditorKit.copyAction,
               "shift INSERT", DefaultEditorKit.pasteAction,
               "shift DELETE", DefaultEditorKit.cutAction,
                 "shift LEFT", DefaultEditorKit.selectionBackwardAction,
              "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
                "shift RIGHT", DefaultEditorKit.selectionForwardAction,
             "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
                  "ctrl LEFT", DefaultEditorKit.previousWordAction,
               "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
                 "ctrl RIGHT", DefaultEditorKit.nextWordAction,
              "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
            "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
         "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
           "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
        "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
                     "ctrl A", DefaultEditorKit.selectAllAction,
                       "HOME", DefaultEditorKit.beginLineAction,
                        "END", DefaultEditorKit.endLineAction,
                 "shift HOME", DefaultEditorKit.selectionBeginLineAction,
                  "shift END", DefaultEditorKit.selectionEndLineAction,
                 "BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
           "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
                     "ctrl H", DefaultEditorKit.deletePrevCharAction,
                     "DELETE", DefaultEditorKit.deleteNextCharAction,
                "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
            "ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction,
                      "RIGHT", DefaultEditorKit.forwardAction,
                       "LEFT", DefaultEditorKit.backwardAction,
                   "KP_RIGHT", DefaultEditorKit.forwardAction,
                    "KP_LEFT", DefaultEditorKit.backwardAction,
                      "ENTER", JTextField.notifyAction,
            "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
             "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
  });

  table.put("TextField.focusInputMap", fieldInputMap);


  table.put("TextField.background", new ColorUIResource(Color.RED));
}