import jtux.*;

class SHM {

    private String name;
    private int size;
    private long semaphore;
    private long mapfile; // File descriptor for mmap file

    /* Lookup flags and perms in your system docs */
    public SHM(String name, int size, boolean create, int flags, int perms) {
        this.name = name;
        this.size = size;
        int shm;
        if (create) {
            flags = flags | UConstant.O_CREAT;
            shm = UPosixIPC.shm_open(name, flags, UConstant.O_RDWR);
        } else {
            shm = UPosixIPC.shm_open(name, flags, UConstant.O_RDWR);
        }
        this.mapfile = UPosixIPC.mmap(..., this.size, ..., flags, shm, 0);
        return;
    }


    public void put(String item) {
        UFile.lseek(this.mapfile(this.mapfile, 0, 0));
        UFile.write(item.getBytes(), this.mapfile);
        return;
    }


    public String get() {    
        UFile.lseek(this.mapfile(this.mapfile, 0, 0));
        byte[] buffer = new byte[this.size];
        UFile.read(this.mapfile, buffer, buffer.length);
        return new String(buffer);
    }


    public void finalize() {
        UPosix.shm_unlink(this.name);
        UPosix.munmap(this.mapfile, this.size);
    }

}