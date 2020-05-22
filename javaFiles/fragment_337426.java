String home = System.getenv("USERPROFILE") + "\\Downloads\\";
String fileName = "xxxxxxxxx.xls";
File file = new File(home + fileName);
if (file.exists()) {
   file.delete();
   System.out.println("Deleted existing CurrentSortRules.xls file if it is already present");
    }
    Window popup = Desktop.describe(Window.class, new WindowDescription.Builder().ownedWindow(false).childWindow(false)
                                .windowClassRegExp("Chrome_WidgetWin_1").windowTitleRegExp(" Google Chrome").build())
                .describe(Dialog.class, new DialogDescription.Builder().ownedWindow(true).childWindow(false)
                        .text("Save As").nativeClass("#32770").build());