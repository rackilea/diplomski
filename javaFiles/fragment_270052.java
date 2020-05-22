switch (error) {
  case "CORRECT":
       setIcon(leafIcon); // sets the icon of the renderer which is a JLabel
       break;
  case "CREATE":
       setIcon(gifNew);
       break;
  case "DELETE":
       setIcon(gifError);
       break;
  ...
}