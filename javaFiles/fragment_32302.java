contentProposalAdapter.addContentProposalListener(new IContentProposalListener2()
    {

        public void proposalPopupClosed(ContentProposalAdapter adapter)
        {
            popupOpen = false;
        }

        public void proposalPopupOpened(ContentProposalAdapter adapter)
        {
            popupOpen = true;
        }
    });