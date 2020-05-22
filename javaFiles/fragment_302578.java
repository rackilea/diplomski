import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.converter.NumberStringConverter;

public class JobProgress {

  private final SimpleDoubleProperty jobProgress;

  public double getJobProgress() {
    return jobProgress.get();
  }

  public void setJobProgress(double value) {
    jobProgress.set(value);
  }

  public SimpleDoubleProperty jobProgressProperty() {
    return jobProgress;
  }

  private final SimpleStringProperty jobProgressString;

  public void setJobProgressString(String value) {
    jobProgressString.set(value);
  }

  public String getJobProgressString() {
    return jobProgressString.get();
  }

  public SimpleStringProperty jobProgressStringProperty() {
    return jobProgressString;
  }

  private final SimpleStringProperty jobName;

  public String getJobStatus() {
    return jobStatus.get();
  }

  public void setJobStatus(String value) {
    jobStatus.set(value);
  }

  private final SimpleStringProperty jobStatus;

  public String getJobName() {
    return jobName.get();
  }

  public void setJobName(String value) {
    jobName.set(value);
  }

  public JobProgress(String jobName, String jobStatus) {
    this.jobName = new SimpleStringProperty(jobName);
    this.jobStatus = new SimpleStringProperty(jobStatus);
    this.jobProgress = new SimpleDoubleProperty(0.0);
    this.jobProgressString = new SimpleStringProperty();
    Bindings.bindBidirectional(jobProgressString, jobProgress, new NumberStringConverter());
  }
}