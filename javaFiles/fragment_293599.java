public interface IHistoryRepository<
  T,
  H extends AbstractHistory<T>
> extends CrudRepository<H, Long> {
    public H findFirst();
}    
public interface StudentHistoryRepository extends IHistoryRepository<Student, StudentHistory> {}
public interface TeacherHistoryRepository extends IHistoryRepository<Teacher, TeacherHistory> {}