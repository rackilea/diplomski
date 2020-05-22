class ApplicationSetting
{
  private string theApplicationSettingString = string.Empty;

  /// <summary>
  /// The name of the setting.
  /// </summary>
  public virtual ApplicationSettingKey SettingName
  {
     //I use enumerations here so that I'm guaranteed to get a key I
     //already know about and not a random string.
     get
     {
        return (ApplicationSettingKey)Enum.Parse(
           typeof(ApplicationSettingKey), theApplicationSettingString);
     }
     set
     {
        theApplicationSettingString =
           Enum.GetName(typeof(ApplicationSettingKey), value);
     }
  }

  /// <summary>
  /// The value of the setting.
  /// </summary>
  public virtual string SettingValue
  {
     get;
     set;
  }
}



/// <summary>
/// Enumeration for all application settings.
/// </summary>
public enum ApplicationSettingKey
{
     WIDTH,
     HEIGHT,
     SHOWALL
}


/// <summary>
/// Returns the ApplicationSetting from the database that corresponds to 
/// the passed in key/name.
/// </summary>
/// <param name="aKey">The key/name of the Application setting to 
/// retrieve.</param>
/// <returns>The ApplicationSetting Definition that with the corresponding
/// application setting key/name.</returns>
public ApplicationSetting GetApplicationSettingByKey(ApplicationSettingKey aKey)
{
    const string propertyName = "theApplicationSettingString";
    string key = Enum.GetName(typeof(ApplicationSettingKey), aKey);
    DetachedCriteria criteria = DetachedCriteria.For<ApplicationSetting>();
    criteria.Add(Restrictions.Eq(propertyName, key));
    return FindFirst(criteria);
}