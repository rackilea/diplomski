import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskEvent.Kind;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeInfo;
import com.sun.source.util.TaskListener;
import com.sun.source.util.TreeScanner;

public class UnsafePlugin implements Plugin, TaskListener {

  @Override
  public String getName() {
    return "UnsafePlugin";
  }

  @Override
  public void init(JavacTask task, String... args) {
    task.addTaskListener(this);
  }

  @Override
  public void finished(TaskEvent taskEvt) {
    if (taskEvt.getKind() == Kind.ANALYZE) {
      taskEvt.getCompilationUnit().accept(new TreeScanner<Void, Void>() {
        @Override
        public Void visitMethodInvocation(MethodInvocationTree methodInv, Void v) {
          Element method = TreeInfo.symbol((JCTree) methodInv.getMethodSelect());
          TypeElement invokedClass = (TypeElement) method.getEnclosingElement();
          String className = invokedClass.toString();
          String methodName = methodInv.getMethodSelect().toString().replaceAll(".*\\.", "");
          System.out.println("Method Invocation: " + className + " : " + methodName);
          return super.visitMethodInvocation(methodInv, v);
        }
      }, null);
    }
  }

  @Override
  public void started(TaskEvent taskEvt) {
  }

}