pageSettingsURL.setWindowState(WindowState.MAXIMIZED);
            pageSettingsURL.setPortletMode(PortletMode.VIEW);

            pageSettingsURL.setParameter(
                "struts_action", "/layout_management/edit_pages");

            if (layout.isPrivateLayout()) {
                pageSettingsURL.setParameter("tabs1", "private-pages");
            }
            else {
                pageSettingsURL.setParameter("tabs1", "public-pages");
            }

            pageSettingsURL.setParameter("redirect", currentURL);
            pageSettingsURL.setParameter(
                "groupId", String.valueOf(scopeGroupId));
            pageSettingsURL.setParameter("selPlid", String.valueOf(plid));