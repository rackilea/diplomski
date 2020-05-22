// UTC Time
var date1 = new DateTime(1969, 4, 20, 2, 20,00, DateTimeKind.Utc);
Console.WriteLine("Date 1: " + date1.ToString() + " - " + date1.IsDaylightSavingTime());

// CEST
var timezone = TimeZoneInfo.FindSystemTimeZoneById("Central European Standard Time");
var date2 = TimeZoneInfo.ConvertTimeFromUtc(date1, timezone);
Console.WriteLine("Date 2: " + date2.ToString() + " - " + date2.IsDaylightSavingTime() + " " + timezone.IsAmbiguousTime(date2));

// Switzerland
var cesAdjRule = timezone.GetAdjustmentRules().Single();
var switzerlandStartTransition = TimeZoneInfo.TransitionTime.CreateFloatingDateRule(
        cesAdjRule.DaylightTransitionStart.TimeOfDay,
        cesAdjRule.DaylightTransitionStart.Month, cesAdjRule.DaylightTransitionStart.Week,
        cesAdjRule.DaylightTransitionStart.DayOfWeek
);
var switzerlandAdjustmentRule = TimeZoneInfo.AdjustmentRule.CreateAdjustmentRule(
    new DateTime(1981, 1, 1),
    DateTime.MaxValue.Date,
    cesAdjRule.DaylightDelta,
    switzerlandStartTransition,
    cesAdjRule.DaylightTransitionEnd
);
TimeZoneInfo.AdjustmentRule[] adjustments = {switzerlandAdjustmentRule};

var switzerlandTimeZone = TimeZoneInfo.CreateCustomTimeZone("Switzerland",
                                                            timezone.BaseUtcOffset,
                                                            "Switzerland",
                                                            "Switzerland",
                                                            "Switzerland",
                                                            adjustments, false);

var date3 = TimeZoneInfo.ConvertTimeFromUtc(date, timezone, switzerlandTimeZone);
Console.WriteLine("Date 3: " + date3.ToString() + " - " + date3.IsDaylightSavingTime() + " " + timezone.IsAmbiguousTime(date3));