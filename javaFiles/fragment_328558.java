import java.net.URL;

// Setting window's icon
String resourcePathToIcon = String.format("/%s/resources/myicon.png",
        MyClass.class.getPackage().getName().replace('.', '/'));
URL windowIconURL = MyClass.class.getResource(resourcePathToIcon);
if (windowIconURL != null)
    setIconImage(new ImageIcon(windowIconURL).getImage());