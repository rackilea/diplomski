private boolean checkPassword(SVNURL url, String user, String password) throws SVNException {
    SVNRepository svnRepository = SVNRepositoryFactory.create(url);
    try {
        svnRepository.setAuthenticationManager(new BasicAuthenticationManager(user, password));
        svnRepository.testConnection();
        return true;
    } catch (SVNException e) {
        if (e.getErrorMessage().getErrorCode() == SVNErrorCode.RA_NOT_AUTHORIZED) {
            return false;
        } else {
            throw e;
        }
    } finally {
        svnRepository.closeSession();
    }
}