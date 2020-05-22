<ScrollPane xmlns:fx="http://javafx.com/fxml" fx:controller="MenuController" fx:id="menuPane" stylesheets="/fxml/styles/menu_style.css" fitToWidth="true" fitToHeight="true" hbarPolicy="ALWAYS" vbarPolicy="ALWAYS">
  <VBox alignment="CENTER" minWidth="${menuPane.viewportBounds.width}">
    <HBox alignment="CENTER">
      <VBox fx:id="menuView">
        <elements></elements>
      </VBox>
    </HBox>
  </VBox>
</ScrollPane>