public aspect FileServiceEventDispatcherAspect {    

pointcut delete(FileService this_, FileEntry entry) :
    execution(void org.service.StructureService.delete(..))
    && args(entry) && this(this_);

void around(FileService this_, FileEntry entry) : delete(this_, entry)  {
        proceed(this_, entry);
}
}