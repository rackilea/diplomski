import groovy.xml.MarkupBuilder
import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpOutputMessage
import org.springframework.http.converter.AbstractHttpMessageConverter

import static org.springframework.http.MediaType.TEXT_HTML

class ExceptionResponseHTMLConverter extends AbstractHttpMessageConverter<ExceptionResponse> {
  ExceptionResponseHTMLConverter() {
    super(TEXT_HTML)
  }

  @Override
  boolean supports(Class clazz) {
    clazz.equals(ExceptionResponse)
  }

  @Override
  ExceptionResponse readInternal(Class clazz, HttpInputMessage msg) {
    throw new UnsupportedOperationException()
  }

  @Override
  void writeInternal(ExceptionResponse e, HttpOutputMessage msg) {
    def sw = new StringWriter()
    new MarkupBuilder(sw).error {
      error(e.error)
      exception(e.exception)
      message(e.message)
      path(e.path)
      status(e.status)
      timestamp(e.timestamp)
    }
    msg.body << sw.toString().bytes
  }
}