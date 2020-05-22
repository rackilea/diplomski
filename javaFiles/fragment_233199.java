class PlayerMembership {
    public final int id;
    public final MembershipType membership;
    public PlayerMembership(int id, MembershipType membership) {
        this.id = id;
        this.membership = membership;
    }
}

List<PlayerMembership> data =
                    em.createQuery("SELECT NEW nl.bart.PlayerMembership(p.id, p.membership) FROM Player p WHERE p.id IN :ids", PlayerMembership.class)
                    .setParameter("ids", ids)
                    .getResultList();