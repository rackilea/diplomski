@RequestMapping(value = "{id}/campaigns/new", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Campaign saveCampaignToChain(@RequestBody Campaign campaign, @PathVariable int id) {
        Chain chain = chainDAO.getChainById(id).get(0);
        chain.getCampaigns().add(campaign);
        campaign.setChain(chain);
        chainDAO.saveChain(chain);
        campaignDAO.saveCampaign(campaign);
        return campaign;
    }