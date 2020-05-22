import java.lang.reflect.Method
import kotlin.coroutines.experimental.intrinsics.*

suspend fun Method.invokeSuspend(obj: Any, vararg args: Any?): Any? =
    suspendCoroutineOrReturn { cont ->
        invoke(obj, *args, cont)
    }