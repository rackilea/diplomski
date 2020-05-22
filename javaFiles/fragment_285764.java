//Attack unit in front
public void Attack(AIUnit unit)
{
    unit.TakeDamage(name);
}

public void TakeDamage(String name)
{
    --health;
    System.out.println(name+" took damage!  Health remaining: "+health);
    if (health == 0)
    {
        System.out.println(name+" is dead!");
        this.Die();
    }
}