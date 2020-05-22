public List<Component> getAllComponents(Class componentClass)
    {
        List<Component> components = new ArrayList<Component>();
        for (Component c : _components)
        {           
            if (c.getClass() == componentClass)
                components.add(c);
        }

        return components;
    }