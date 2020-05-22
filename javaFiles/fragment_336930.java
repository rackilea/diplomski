import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AffiliateTrackingFilter implements Filter {
    private AffiliateTrackingService affiliateTrackingService = null;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs,
            FilterChain chain) throws IOException, ServletException {
        String affililateId = rq.getParameter("affiliateId");
        affiliateTrackingService.incrementAffiliateHit(affililateId);
        chain.doFilter();
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        affiliateTrackingService = new AffiliateTrackingService();
    }
}