public class UiCodeFilter extends OncePerRequestFilter {

    protected void doFilterInternally(HttpServletRequest req, HttpServletResponse res, FilterChain chain) {
        try {
            String uiCode = req.getHeader("uiCode");

            if ((uiCode != null && !uiCode.trim().isEmpty())) {
                UiCodeDto uiCodeDto = new UiCodeDto(uiCode);
                UiCodeHolder.set(uiCodeDta);
            }
            chain.doFilter(req, res);
        } finally {
            UiCodeHolder.clear(); // Always clear!
        }

    }
}