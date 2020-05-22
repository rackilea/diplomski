onAction = (ae: ActionEvent) =>  {
  val helpStage = new Stage() {

    // Make room for the list view and the text flow.
    width = 400

    // Set the help text to the default.
    val defaultText = "Please make\na selection"
    val helpText = new Text(defaultText)

    // Help for each option in the list view. If a key doesn't match, then the default
    // text is displayed.
    val optionText = Map(
      "Option 1" -> "This is\nsome help for\nOption 1",
      "Option 2" -> "And this is\nsome help for\nOption 2",
      "Option 3" -> "Finally, this is\nsome help for\nOption 3",
    ).withDefaultValue(defaultText)

    // Title the stage and set the scene...
    title = "A wild help stage appears!"
    scene = new Scene {

      val listView = new ListView(List.tabulate(3) { n => "Option " + (n + 1) }) {

        // Change the help text when the selection changes.
        selectionModel().selectedItem.onChange {(_, _, selected) =>
          helpText.text = optionText(selected);
        }
      }

      // Add the help text to the text flow.
      val textFlow = new TextFlow(helpText)

      // Put list view and text flow elements side-by-side.
      content = new HBox(listView, textFlow)
    }
  }
  helpStage.show()
}