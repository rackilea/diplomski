public static final Map<String, String> challenges = new HashMap<String, String>();

    static {
        challenges.put("RzrvZ9gd7EH3i_TsJM-B0vdEMslD4oo_lwsagGskp6c",
                "RzrvZ9gd7EH3i_TsJM-B0vdEMslD4oo_lwsagGskp6c.ONrZa3UelibSWEX270nTUiRZKPFXw096nENWbMGw0-E");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (!req.getRequestURI().startsWith("/.well-known/acme-challenge/")) {
            resp.sendError(404);
            return;
        }
        String id = req.getRequestURI().substring("/.well-known/acme-challenge/".length());
        if (!challenges.containsKey(id)) {
            resp.sendError(404);
            return;
        }
        resp.setContentType("text/plain");
        resp.getOutputStream().print(challenges.get(id));
    }
}