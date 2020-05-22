package wrappers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class SendErrorResponseWrapper extends HttpServletResponseWrapper {

    HttpServletRequest _request;
    HttpServletResponse _wrappedResponse;

    public SendErrorResponseWrapper(HttpServletRequest request, HttpServletResponse response) {

        super(response);

        _request= request;
        _wrappedResponse= response;
    }

    @Override
    public void sendError(intstatus) throwsIOException {

        String path = _request.getServletPath() + _request.getPathInfo();

        if(status == 403 && path.endsWith("html/")) {
            _wrappedResponse.sendError(404);
        } else{
            _wrappedResponse.sendError(status);
        }
    }

    @Override
    public void sendError(intstatus, String msg) throwsIOException {

        String path = _request.getServletPath() + _request.getPathInfo();

        if(status == 403 && path.endsWith("html/")) {
            _wrappedResponse.sendError(404, msg);
        } else{
            _wrappedResponse.sendError(status, msg);
        }
    }

}