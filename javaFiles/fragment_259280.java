@Hint(category="bitwise_operations", suppressWarnings="IncompatibleBitwiseMaskOperation")
@Hint(category="initialization", suppressWarnings="LeakingThisInConstructor")
@Hint(category="logging", suppressWarnings={"NonConstantLogger"}) //NOI18N
@Hint(category="logging", suppressWarnings={"ClassWithMultipleLoggers"}) //NOI18N
@Hint(category="logging", suppressWarnings={"ClassWithoutLogger"}, enabled=false) //NOI18N
@Hint(category="code_maturity", suppressWarnings="UseOfObsoleteCollectionType")
@Hint(category="initialization", suppressWarnings="OverridableMethodCallInConstructor")
@Hint(category="bitwise_operations", suppressWarnings="PointlessBitwiseExpression")
@Hint(category="code_maturity", suppressWarnings="CallToThreadDumpStack")
@Hint(category="bitwise_operations", suppressWarnings="ShiftOutOfRange")
@Hint(category="initialization", suppressWarnings="StaticNonFinalUsedInInitialization")
@Hint(category="code_maturity", enabled = false, suppressWarnings="UseOfSystemOutOrSystemErr")
@Hint(category="code_maturity", suppressWarnings="CallToPrintStackTrace")