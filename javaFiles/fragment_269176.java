Document document = JOOX.builder().newDocument();
Element root = document.createElement("contacts");
document.appendChild(root);

for (String name : new String[]{"John", "Jessica", "Peter"}) {
  $(root).append(
    $("contact"
      , $("name", name)
      , $("active", "true")
    )
  );
}