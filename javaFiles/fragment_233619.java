package org.eclipse.jetty.embedded;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class ImageHandler extends AbstractHandler {

    public ImageHandler() { }

    public void handle( final String target,
                        final Request baseRequest,
                        final HttpServletRequest request,
                        final HttpServletResponse response )
      throws IOException, ServletException
    {
      final byte[] image = getImage();
      response.setHeader( "Content-Type", "image/png" );
      response.setHeader( "Content-Length", image.length );
      response.setStatus( HttpServletResponse.SC_OK );
      response.getOutputStream().write( image );

      baseRequest.setHandled( true );
    }
}