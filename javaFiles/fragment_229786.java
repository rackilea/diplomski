BulletinDAO bulletinDAOInstance = new BulletinDAO();

    if (approve != null) {
        if (bulletinDAOInstance.approveBulletin(id) == true) {
            HttpSession session = (HttpSession) request.getSession();
            session.setAttribute("confirmation",
                    "Your bulletin has been approved.");
            return "success";
        }
    }

    if (deny != null) {
        if (bulletinDAOInstance.denyBulletin(id) == true) {
            HttpSession session = (HttpSession) request.getSession();
            session.setAttribute("confirmation",
                    "Your bulletin has been denied.");
            return "success";
        }
    }

    return "failure";