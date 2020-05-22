Path source = ...;
Path target = ...;
Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);

FileTime creationTime  = (FileTime) Files.readAttributes(source, "creationTime").get("creationTime");
Files.setAttribute(target, "creationTime", creationTime);