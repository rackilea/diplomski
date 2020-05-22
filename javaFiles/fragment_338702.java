public StreamedContent getAgencyPhoto() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String agencyId = context.getExternalContext()
                    .getRequestParameterMap().get("agencyId");
            TAgency currentAgency = new TAgency();
            for (TAgency currAgency : agencyList) {
                if (currAgency.gettUserId() == Long.valueOf(agencyId))
                    currentAgency = currAgency;

            }
            byte[] image = (byte[]) currentAgency.gettUser().getPhoto();
            if (image == null) {
                return new DefaultStreamedContent();
            } else {
                return new DefaultStreamedContent(new ByteArrayInputStream(
                        image));
            }
        }
    }