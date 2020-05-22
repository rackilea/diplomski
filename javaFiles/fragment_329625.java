private void buttonSaveAsActionPerformed(java.awt.event.ActionEvent evt) {                                             
        final StringListModel<Meter> model = getListModel();
        final Meter edited = meterEditionPanel.getMeter();

        if (edited == null)
            return;

        try { 
            service.createEntity(edited);
            model.update();
            listMeters.setSelectedValue(edited.getAlias(), true);
            meterEditionPanel.setMeter(edited);
        } catch (BeansException | HibernateException ex) {
            FieldMarker.showEntityAlreadyExistsInCompanyDialog(
                    dictionary.getString("commons.title.meter"),
                    dictionary.getString("commons.text.serialNumber"), false);
            LOGGER.debug("Não foi possível atualizar o medidor: " + ex.toString());
        }
    }