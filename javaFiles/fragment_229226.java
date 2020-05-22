import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class CustomRequestLoggingFilter extends AbstractRequestLoggingFilter {

  protected final Logger log4jLogger = LogManager.getLogger(getClass());

  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
    if (log4jLogger.isDebugEnabled()) {
      log4jLogger.debug(message);
    }
    ThreadContext.push(getNestedDiagnosticContextMessage(request));
  }

  @Override
  protected void afterRequest(HttpServletRequest request, String message) {
    ThreadContext.pop();
    if (ThreadContext.getDepth() == 0) {
      ThreadContext.removeStack();
    }
    if (log4jLogger.isDebugEnabled()) {
      log4jLogger.debug(message);
    }
  }

  protected String getNestedDiagnosticContextMessage(HttpServletRequest request) {
    return createMessage(request, "", "");
  }
}