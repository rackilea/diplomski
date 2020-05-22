@Test
public void testButtonClick(){
    final Button button = find("#button"); // requires your button to be tagged with setId("button")
    click(button);
    // verify any state change expected on click.
}