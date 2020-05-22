public class Action
        {
            private static Dictionary<Type, Action<Parent>> _d;

            static Action()
            {
                Initialize();
            }

            private static void Initialize()
            {
                var methods = typeof(Action)
                    .GetMethods(BindingFlags.Static | BindingFlags.Public | BindingFlags.NonPublic)
                    .Where(IsActionMethod)
                    .ToList();

                _d = methods.ToDictionary(m => m.GetParameters().First().ParameterType,
                                          m => (Action<Parent>) (x => m.Invoke(null, new[] {x})));
            }

            private static bool IsActionMethod(MethodInfo methodInfo)
            {
                var parameters = methodInfo.GetParameters();

                return parameters.Length == 1
                       && typeof(Parent).IsAssignableFrom(parameters.First().ParameterType)
                       && methodInfo.ReturnType == typeof(void);
            }

            public static void perform(Parent p)
            {
                _d[p.GetType()](p);
            }

            private static void action(Parent p)
            {

            }

            private static void action(Child1 c1)
            {

            }

            private static void action(Child2 c2)
            {

            }
}