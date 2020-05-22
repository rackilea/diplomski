/**
 * Get a String showing all packages and rules in a knowledge base.
 */
public String kbString(KnowledgeBase kbase) {
    StringBuilder sb = new StringBuilder();
    for (KnowledgePackage p : kbase.getKnowledgePackages()) {
        sb.append("\n  Package : " + p.getName());
        for (Rule r : p.getRules()) {
            sb.append("\n    Rule: " + r.getName());
        }
    }
    return "Knowledge base built with packages: " + sb.toString();
}

/**
 * Get a String showing the facts currently in working memory, 
 * and their details.
 * 
 * @param session The session to search for facts.
 */
public String sessionFactsString(StatefulKnowledgeSession session) {
    StringBuilder sb = new StringBuilder();
    sb.append("\nThe following facts are currently in the system...");
    for (Object fact : session.getObjects()) {
        sb.append("\n\nFact: " + DroolsUtil.objectDetails(fact));
    }
    return sb.toString();
}