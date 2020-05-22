import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DepartmentRepository
{

  private static final ReentrantReadWriteLock lock =
    new ReentrantReadWriteLock(true);

  private static Collection<Department> departments = null;

  public Collection<Department> getAllDepartments()
  {
    Lock read = lock.readLock();
    read.lock();
    try {
      /* Check whether the departments are loaded. */
      if (departments == null) {
        /* If not loaded, release read-lock and acquire write-lock. */
        read.unlock();
        Lock write = lock.writeLock();
        write.lock();
        try {
          /* Recheck condition for updates by another thread. */
          if (departments == null) {
            Collection<Department> tmp = ...; // Initialize. 
            departments = Collections.unmodifiableCollection(tmp);
          }
          /* Downgrade from write-lock to read-lock. */
          read.lock();
        }
        finally {
          write.unlock();
        }
      }
      return departments;
    }
    finally {
      read.unlock();
    }
  }

  public void clearCache()
  {
    Lock write = lock.writeLock();
    write.lock();
    try {
      departments = null;
    }
    finally {
      write.unlock();
    }
  }

}