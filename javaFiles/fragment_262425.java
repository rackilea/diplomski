...
final Path changed = (Path) event.context();
WatchEvent.Kind<?> kind = event.kind();
if (changed.toString().startsWith("TEST.docx")) {
                    if(kind==StandardWatchEventKinds.ENTRY_CREATE){

                System.out.println("New File Added, file Name " + fileName);
            }

}